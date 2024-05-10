create table if not exists `configs` (
        `app` varchar(64) not null,
        `env` varchar(64) not null,
        `ns` varchar(64) not null,
        `pkey` varchar(64) not null,
        `pval` varchar(64) default null
);

