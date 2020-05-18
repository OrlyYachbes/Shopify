package database;

public class DataBase {
    private static DataBase dataBase_instance = null;
    private DataBase(){};
    public static DataBase getInstance(){
        if(dataBase_instance == null)
            dataBase_instance = new DataBase();
        return  dataBase_instance;
    }

    //functions......
}
