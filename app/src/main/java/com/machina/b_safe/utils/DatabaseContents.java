package com.machina.b_safe.utils;

public enum DatabaseContents {
    DATABASE("loginsederhana.db"),
    TABLE_USERS("tbl_users");

    private String name;

    /**
     * Constructs DatabaseContents.
     * @param name name of this content for using in database.
     */
    private DatabaseContents(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}

// Class DatabaseContents ini berguna untuk mendefinisikan nama database serta nama tabel - tabelnya.