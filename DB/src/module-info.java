module DB {
    requires java.sql;
    requires Handlers;
    exports postgres to VirtualClassroom;
}