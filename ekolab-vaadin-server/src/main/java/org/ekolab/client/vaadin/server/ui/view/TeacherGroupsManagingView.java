package org.ekolab.client.vaadin.server.ui.view;

import com.vaadin.data.provider.GridSortOrder;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import org.ekolab.client.vaadin.server.service.impl.I18N;
import org.ekolab.client.vaadin.server.ui.EkoLabNavigator;
import org.ekolab.client.vaadin.server.ui.styles.EkoLabTheme;
import org.ekolab.client.vaadin.server.ui.view.api.View;
import org.ekolab.client.vaadin.server.ui.windows.AddTeacherGroupsWindow;
import org.ekolab.server.model.StudentGroupInfo;
import org.ekolab.server.model.UserProfile;
import org.ekolab.server.service.api.StudentInfoService;
import org.ekolab.server.service.api.content.UserLabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Set;

@SpringView(name = TeacherGroupsManagingView.NAME)
public class TeacherGroupsManagingView extends GridLayout implements View {
    public static final String NAME = "teacher-account";

    private final Authentication currentUser;

    private final AddTeacherGroupsWindow addTeacherGroupsWindow;

    private final UserLabService userLabService;

    private final StudentInfoService studentInfoService;

    private final EkoLabNavigator navigator;

    private final I18N i18N;

    // ---------------------------- Графические компоненты --------------------
    private final Label userInitialsLabel = new Label("Surname Firstname Lastname");
    private final Label todayDate = new Label();
    private final Grid<StudentGroupInfo> groups = new Grid<>();
    private final Button manageGroupButton = new Button("View group", event ->
            manageGroup(groups.getSelectedItems().iterator().next()));
    private final Button addGroupButton = new Button();
    private final Button removeGroupButton = new Button();
    private final HorizontalLayout buttons = new HorizontalLayout(addGroupButton, removeGroupButton);

    @Autowired
    public TeacherGroupsManagingView(Authentication currentUser,
                                     AddTeacherGroupsWindow addTeacherGroupsWindow, UserLabService userLabService, StudentInfoService studentInfoService, EkoLabNavigator navigator, I18N i18N) {
        super(5, 5);
        this.currentUser = currentUser;
        this.addTeacherGroupsWindow = addTeacherGroupsWindow;
        this.userLabService = userLabService;
        this.studentInfoService = studentInfoService;
        this.navigator = navigator;
        this.i18N = i18N;
    }

    @Override
    public void init() throws Exception {
        View.super.init();
        setMargin(true);
        setSpacing(true);

        setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);

        addComponent(userInitialsLabel, 0, 0, 0, 0);
        addComponent(todayDate, 0, 1, 0, 1);
        addComponent(groups, 1, 0, 4, 3);
        addComponent(manageGroupButton, 1, 4, 1, 4);
        addComponent(buttons, 3, 4, 4, 4);
        setComponentAlignment(manageGroupButton, Alignment.MIDDLE_LEFT);
        setComponentAlignment(buttons, Alignment.MIDDLE_RIGHT);

        groups.setSizeFull();

        groups.setSelectionMode(Grid.SelectionMode.SINGLE);
        groups.addItemClickListener(event -> {
            if (event.getMouseEventDetails().isDoubleClick()) {
                manageGroup(event.getItem());
            }
        });

        groups.addSelectionListener(event -> {
            if (event.getAllSelectedItems().isEmpty()) {
                manageGroupButton.setEnabled(false);
                removeGroupButton.setEnabled(false);
            } else {
                manageGroupButton.setEnabled(true);
                removeGroupButton.setEnabled(true);
            }
        });

        manageGroupButton.setEnabled(false);
        addGroupButton.setCaption(i18N.get("student-data.add-group"));
        addGroupButton.setStyleName(EkoLabTheme.BUTTON_PRIMARY);
        addGroupButton.addClickListener(event -> {
            Set<StudentGroupInfo> selected = groups.getSelectedItems();
            addTeacherGroupsWindow.show(new AddTeacherGroupsWindow.AddTeacherGroupsWindowSettings(currentUser.getName(), () -> {
                refreshTeacherGroups(selected);
            }));
        });

        removeGroupButton.setEnabled(false);
        removeGroupButton.setCaption(i18N.get("student-data.remove-group"));
        removeGroupButton.setStyleName(EkoLabTheme.BUTTON_DANGER);
        removeGroupButton.addClickListener(event -> {
            Set<StudentGroupInfo> selected = groups.getSelectedItems();
            if (!selected.isEmpty()) {
                selected.forEach(s -> studentInfoService.removeGroupFromTeacher(currentUser.getName(), s.getName()));
                refreshTeacherGroups(selected);
            }
        });

        manageGroupButton.setCaption(i18N.get("teacher-group-manage.view-group"));
        manageGroupButton.setStyleName(EkoLabTheme.BUTTON_PRIMARY);
        Grid.Column<StudentGroupInfo, Integer> number = groups.addColumn(StudentGroupInfo::getIndex).setCaption(i18N.get("teacher-group-manage.groups.number"));
        groups.addColumn(StudentGroupInfo::getName).setCaption(i18N.get("teacher-group-manage.groups.name"));
        groups.addColumn(StudentGroupInfo::getStudentCount).setCaption(i18N.get("teacher-group-manage.groups.student-count"));
        groups.addColumn(studentGroupInfo -> studentGroupInfo.getLabCount()+ "/3").setCaption(i18N.get("teacher-group-manage.groups.lab-count"));
        groups.addColumn(studentGroupInfo -> studentGroupInfo.getDefenceCount()+ "/3").setCaption(i18N.get("teacher-group-manage.groups.defence-count"));

        groups.setSortOrder(Collections.singletonList(new GridSortOrder<>(number, SortDirection.ASCENDING)));

        userInitialsLabel.setContentMode(ContentMode.HTML);
        todayDate.setContentMode(ContentMode.HTML);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        refreshTeacherGroups(Collections.emptySet());
        UserProfile userProfile = userLabService.getUserProfile(currentUser.getName());

        todayDate.setValue(i18N.get("teacher-group-manage.today-date", LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                "" /*LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm"))*/));

        userInitialsLabel.setValue(i18N.get("teacher-group-manage.initials", userProfile.getUserInfo().getLastName(),
                userProfile.getUserInfo().getFirstName(), userProfile.getUserInfo().getMiddleName()));
    }

    private void refreshTeacherGroups(@NotNull Set<StudentGroupInfo> selected) {
        groups.setItems(studentInfoService.getTeacherGroupsInfo(currentUser.getName()));
        if (selected.isEmpty()) {
            removeGroupButton.setEnabled(false);
        } else {
            selected.forEach(groups::select);
            removeGroupButton.setEnabled(true);
        }
    }

    private void manageGroup(StudentGroupInfo group) {
        navigator.redirectToView(GroupManagingView.NAME + '/' + GroupManagingView.GROUP_NAME  + '=' + group.getName());
    }
}