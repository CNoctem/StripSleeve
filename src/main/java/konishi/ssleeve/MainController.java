package konishi.ssleeve;

import konishi.ssleeve.data.Album;
import konishi.ssleeve.data.User;
import konishi.ssleeve.data.repo.AlbumRepository;
import konishi.ssleeve.data.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;

@Controller
@ComponentScan("erste.renew.sgt.data")
public class MainController {

    public static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AlbumRepository albumRepo;

    @GetMapping(path="/add")
    public @ResponseBody String addNewUser () {
        User n = new User();
        n.setFullName("User");
        n.setName("Fullname");
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @GetMapping(path="/addalbum")
    public @ResponseBody String addNewAlbum () {
        Album a = new Album();
        a.setName("AlbumName");
        a.setCreationDate(getCurrentTime());
        a.setOwnerId(2);
        albumRepo.save(a);
        return "Saved";
    }

    @GetMapping(path="/albums")
    public @ResponseBody Iterable<Album> getAllAlbum() {
        // This returns a JSON or XML with the users
        return albumRepo.findAll();
    }

    private static String getCurrentTime() {
        return DATEFORMAT.format(new java.util.Date());
    }


}