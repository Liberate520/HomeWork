package notes;

import com.google.gson.Gson;

public class Formatter {
    public String parseOut(Notes notes){
        Gson gson = new Gson();
        String jsonString = gson.toJson(notes);
        return jsonString;
    }

    public Notes parseIn(String jsonString){
        Gson gson = new Gson();
        Notes note = gson.fromJson(jsonString, Notes.class);
        return note;
    }
}
