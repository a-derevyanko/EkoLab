CREATE TABLE STUDY_GROUPS (
  id      BIGINT GENERATED BY DEFAULT AS IDENTITY ( START WITH 0) PRIMARY KEY,
  version INT,
  name    VARCHAR(256) UNIQUE NOT NULL,
);

CREATE UNIQUE INDEX IX_STUDY_GROUPS
  ON STUDY_GROUPS (id);

COMMENT ON TABLE STUDY_GROUPS IS 'Учебные группы';
COMMENT ON COLUMN STUDY_GROUPS.id IS 'Идентификатор учебной группы';
COMMENT ON COLUMN STUDY_GROUPS.version IS 'Версия изменений(контроль одновременного доступа)';
COMMENT ON COLUMN STUDY_GROUPS.name IS 'Название учебной группы';

CREATE TABLE STUDY_GROUP_MEMBERS (
  id       BIGINT GENERATED BY DEFAULT AS IDENTITY ( START WITH 0) PRIMARY KEY,
  version  INT,
  user_id  BIGINT NOT NULL REFERENCES users (id) ON DELETE CASCADE,
  group_id BIGINT NOT NULL REFERENCES study_groups (id) ON DELETE CASCADE,
);

CREATE UNIQUE INDEX IX_STUDY_GROUP_MEMBERS
  ON STUDY_GROUP_MEMBERS (id);

COMMENT ON TABLE STUDY_GROUP_MEMBERS IS 'Члены учебных групп';
COMMENT ON COLUMN STUDY_GROUP_MEMBERS.id IS 'Идентификатор записи';
COMMENT ON COLUMN STUDY_GROUP_MEMBERS.version IS 'Версия изменений(контроль одновременного доступа)';
COMMENT ON COLUMN STUDY_GROUP_MEMBERS.user_id IS 'Идентификатор студента';
COMMENT ON COLUMN STUDY_GROUP_MEMBERS.group_id IS 'Идентификатор учебной группы';

CREATE UNIQUE INDEX ix_study_group_members_user_group
  ON study_group_members (user_id, group_id);

CREATE TABLE STUDY_TEAMS (
  id      BIGINT GENERATED BY DEFAULT AS IDENTITY ( START WITH 0) PRIMARY KEY,
  version INT,
  number  INT UNIQUE NOT NULL,
);

CREATE UNIQUE INDEX IX_STUDY_TEAMS
  ON STUDY_TEAMS (id);

COMMENT ON TABLE STUDY_TEAMS IS 'Студенческие бригады';
COMMENT ON COLUMN STUDY_TEAMS.id IS 'Идентификатор студенческой бригады';
COMMENT ON COLUMN STUDY_TEAMS.version IS 'Версия изменений(контроль одновременного доступа)';
COMMENT ON COLUMN STUDY_TEAMS.number IS 'Номер студенческой бригады';

CREATE TABLE STUDY_TEACHERS (
  id      BIGINT GENERATED BY DEFAULT AS IDENTITY ( START WITH 0) PRIMARY KEY,
  version INT,
  STUDENT_ID  BIGINT NOT NULL REFERENCES users (id) ON DELETE CASCADE,
  TEACHER_ID  BIGINT NOT NULL REFERENCES users (id) ON DELETE CASCADE,
);

CREATE UNIQUE INDEX IX_STUDY_TEACHERS
  ON STUDY_TEACHERS (STUDENT_ID);

COMMENT ON TABLE STUDY_TEACHERS IS 'Связь студентов и преподавателей';
COMMENT ON COLUMN STUDY_TEACHERS.id IS 'Идентификатор записи';
COMMENT ON COLUMN STUDY_TEACHERS.version IS 'Версия изменений(контроль одновременного доступа)';
COMMENT ON COLUMN STUDY_TEACHERS.STUDENT_ID IS 'Идентификатор студента';
COMMENT ON COLUMN STUDY_TEACHERS.TEACHER_ID IS 'Идентификатор преподавателя';

CREATE TABLE STUDY_TEAM_MEMBERS (
  id      BIGINT GENERATED BY DEFAULT AS IDENTITY ( START WITH 0) PRIMARY KEY,
  version INT,
  user_id BIGINT NOT NULL REFERENCES users (id) ON DELETE CASCADE,
  team_id BIGINT NOT NULL REFERENCES study_teams (id) ON DELETE CASCADE,
);

CREATE UNIQUE INDEX IX_STUDY_TEAM_MEMBERS
  ON STUDY_TEAM_MEMBERS (id);

COMMENT ON TABLE STUDY_GROUP_MEMBERS IS 'Члены студенческих бригад';
COMMENT ON COLUMN STUDY_GROUP_MEMBERS.id IS 'Идентификатор записи';
COMMENT ON COLUMN STUDY_GROUP_MEMBERS.version IS 'Версия изменений(контроль одновременного доступа)';
COMMENT ON COLUMN STUDY_GROUP_MEMBERS.user_id IS 'Идентификатор студента';
COMMENT ON COLUMN STUDY_GROUP_MEMBERS.group_id IS 'Идентификатор студенческой бригады';

CREATE UNIQUE INDEX ix_study_team_members_user_team
  ON study_team_members (user_id, team_id);