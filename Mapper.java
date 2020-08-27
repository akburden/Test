import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PersonMapper {

    public static List<personDTO> map(HashMap<String, ArrayList<String>> data){
        ArrayList<personDTO> peopleDTO = new ArrayList<personDTO>();
        for(int i = 0; data.get("NAME").size(); i++){
            peopleDTO.add(new personDTO(data.get("NAME").get(i), Integer.parseInt(data.get("AGE").get(i))));
        }
        return peopleDTO;
    }

}
