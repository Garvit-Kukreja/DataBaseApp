package com.example.android.databaseapp.Contract;

import android.provider.BaseColumns;

/**
 * Created by Garvit on 24-May-18.
 */

public class ContractGuest {
    public static final class GuestInfo implements BaseColumns{
        public static final String TableName ="GuestList";
        public static final String Column_Id ="Id";
        public static final String Column_Name ="Name";
        public static final String Column_Company="Company";
        public static final String Column_Type="Type";

    }
}
