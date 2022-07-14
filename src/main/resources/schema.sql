drop table if exists PRODUCTS;

create table PRODUCTS (
    NAME varchar(100) not null,
    ITEM_PER_CARTON int,
    CARTON_PRICE double,
    PRIMARY KEY (NAME)
)