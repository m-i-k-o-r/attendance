create table study_group
(
    id     bigint generated by default as identity primary key,
    number int not null,
    course int not null
);


create table student
(
    id_number bigint primary key,
    full_name text   not null,
    group_id  bigint not null,

    foreign key (group_id) references study_group (id) on delete cascade
);
comment on column student.id_number is 'номер студенческого билета';
comment on column student.full_name is 'Ф.И.О.';


create table professor
(
    id        uuid default gen_random_uuid() primary key,
    email     text not null unique,
    password  text not null,
    full_name text not null
);
comment on column professor.full_name is 'Ф.И.О.';


create table discipline
(
    id           uuid default gen_random_uuid() primary key,
    name         text   not null,
    group_id     bigint not null,
    professor_id uuid   not null,

    foreign key (group_id) references study_group (id) on delete cascade,
    foreign key (professor_id) references professor (id) on delete cascade
);


create table schedule
(
    id            uuid default gen_random_uuid() primary key,
    time_start    time not null,
    time_end      time not null,
    weekday       text not null,
    frequency     int  not null,
    discipline_id uuid not null,

    foreign key (discipline_id) references discipline (id) on delete cascade
);
comment on column schedule.frequency is '0 - каждую неделю, 1 - числитель, 2 - знаменатель';


create table attendance
(
    id            uuid default gen_random_uuid() primary key,
    date_time     timestamp not null,
    is_complete   bool      not null,
    students      text,
    discipline_id uuid      not null,

    foreign key (discipline_id) references discipline (id) on delete cascade
);
comment on column attendance.students is 'список отметившихся студентов';