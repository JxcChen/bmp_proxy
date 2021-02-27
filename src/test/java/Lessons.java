import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import static spark.Spark.*;


public class Lessons {

    public static HashMap<String,Lesson> lessons = new HashMap<String, Lesson>();

    public static void main(String[] args) {
        port(8888);
        post("/lesson",(request,response) ->{
            String name = request.queryParams("name");
            String language = request.queryParams("language");
            String price = request.queryParams("price");
            Lesson lesson = new Lesson(name,language,price);
            Random random = new Random();
            int id = random.nextInt(Integer.MAX_VALUE);
            lessons.put(String.valueOf(id),lesson);
            response.status(201);
            return id;
        });


        get("/lesson/:id",(request, response) -> {
            Lesson lesson = lessons.get(request.params(":id"));
            if(lesson != null){
                return "Name:" + lesson.getName() + "Language" + lesson.getLanguage() + "Price:" + lesson.getPrice();
            }else {
                response.status(404);
                return "lesson is null";
            }

        });
        get("/lessons",(request, response) -> {
            Set<String> strings = lessons.keySet();
            if (strings.size()>0){
                Object[] objects = strings.toArray();
                return objects[0].toString();
            }

            return "id is null";
        });
    }
}
