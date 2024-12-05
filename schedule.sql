CREATE TABLE `schedule` (
                            `scheduleID`	INT 	AUTO_INCREMENT	PRIMARY KEY,
                            `writerID`	VARCHAR(10)	NOT NULL,
                            `works`	TEXT	NOT NULL,
                            `password`	VARCHAR(20)	NOT NULL,
                            `createdAt`	DATETIME	NOT NULL,
                            `updatedAt`	DATETIME	NOT NULL
);

create table `writer` (
                          `writerID` INT auto_increment primary key,
                          `writerName` varchar(15) not null,
                          `email` varchar(75) not null,
                          `createdAt` datetime not null,
                          `updatedAt` datetime not null
);

insert into writer (`writerName`, `email`, `createdAt`, `updatedAt`)
values ("test1", "test1@mail.com", "2024-12-01 10:35:17", "2024-12-01 10:35:17");
insert into writer (`writerName`, `email`, `createdAt`, `updatedAt`)
values ("test2", "test2@mail.com", "2024-12-04 15:06:09", "2024-12-04 15:06:09");
insert into writer (`writerName`, `email`, `createdAt`, `updatedAt`)
values ("test3", "test3@mail.com", "2024-12-02 21:12:48", "2024-12-02 21:12:48");
insert into writer (`writerName`, `email`, `createdAt`, `updatedAt`)
values ("test4", "test4@mail.com", "2024-12-03 11:53:27", "2024-12-03 11:53:27");
insert into writer (`writerName`, `email`, `createdAt`, `updatedAt`)
values ("test5", "test5@mail.com", "2024-12-05 01:21:32", "2024-12-05 01:21:32");

insert into schedule (`writerID`, `works`, `password`, `createdAt`, `updatedAt`)
values (5, "reservation for restaurant", "testpass1", "2024-12-02 12:53:27", "2024-12-02 12:53:27");
insert into schedule (`writerID`, `works`, `password`, `createdAt`, `updatedAt`)
values (7, "biking", "testpass2", "2024-12-02 21:23:26", "2024-12-02 21:23:26");
insert into schedule (`writerID`, `works`, `password`, `createdAt`, `updatedAt`)
values (8, "application for lecture", "testpass3", "2024-12-04 12:35:27", "2024-12-04 12:35:27");
insert into schedule (`writerID`, `works`, `password`, `createdAt`, `updatedAt`)
values (9, "hospital", "testpass4", "2024-12-05 13:51:22", "2024-12-05 13:51:22");
insert into schedule (`writerID`, `works`, `password`, `createdAt`, `updatedAt`)
values (6, "meet friend", "testpass5", "2024-12-01 10:10:10", "2024-12-01 10:10:10");
insert into schedule (`writerID`, `works`, `password`, `createdAt`, `updatedAt`)
values (7, "go to study cafe", "testpass6", "2024-12-05 07:30:13", "2024-12-05 07:30:13");
insert into schedule (`writerID`, `works`, `password`, `createdAt`, `updatedAt`)
values (5, "travel", "testpass7", "2024-12-01 11:10:09", "2024-12-01 11:10:09");
insert into schedule (`writerID`, `works`, `password`, `createdAt`, `updatedAt`)
values (6, "museum", "testpass8", "2024-12-05 15:42:42", "2024-12-05 15:42:42");
insert into schedule (`writerID`, `works`, `password`, `createdAt`, `updatedAt`)
values (8, "resting", "testpass9", "2024-12-03 19:29:17", "2024-12-03 19:29:17");
insert into schedule (`writerID`, `works`, `password`, `createdAt`, `updatedAt`)
values (9, "reservation for restaurant", "testpass10", "2024-12-05 12:03:20", "2024-12-05 12:03:20");