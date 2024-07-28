module DB.src {
	requires java.sql;
	requires Handlers.src;
	exports postgres to VirtualClassroom.src;
}