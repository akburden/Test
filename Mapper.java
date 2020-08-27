import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class PersonMapper {

    public static List<PersonDTO> map(Map<String, List<String>> data){
        ArrayList<PersonDTO> peopleDTO = new ArrayList<PersonDTO>();
        for(int i = 0; data.get("NAME").size(); i++){
            peopleDTO.add(new PersonDTO(data.get("NAME").get(i), Integer.parseInt(data.get("AGE").get(i))));
        }
        return peopleDTO;
    }

}
