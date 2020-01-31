package konishi.ssleeve;

import konishi.ssleeve.data.Album;
import konishi.ssleeve.data.Photo;
import konishi.ssleeve.data.User;
import konishi.ssleeve.data.repo.AlbumRepository;
import konishi.ssleeve.data.repo.PhotoRepository;
import konishi.ssleeve.data.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Iterator;

@Controller
public class MainController {

    public static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AlbumRepository albumRepo;

    @Autowired
    private PhotoRepository photoRepository;

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

    @GetMapping(path="/addalbum/{albumName}")
    public @ResponseBody String addNewAlbum (@PathVariable String albumName) {
        Album a = new Album();
        a.setName(albumName);
        a.setCreationDate(getCurrentTime());
        a.setOwnerId(3);
        albumRepo.save(a);
        return "Saved";
    }

    @GetMapping(path="/albums")
    public @ResponseBody Iterable<Album> getAllAlbum() {
        // This returns a JSON or XML with the users
        return albumRepo.findAll();
    }

    @GetMapping(path="/addphoto/**")
    public @ResponseBody String addPhoto(HttpServletRequest request) {
        Photo p = new Photo();
        String servletPath = ((String) request.getAttribute(
                HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE)).replace("*", "");
        String path = ((String) request.getAttribute(
                HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE)).substring(servletPath.length());
        p.setFileName(path.substring(path.lastIndexOf("/") + 1));
        p.setLastPath(path);
        p.setOrigDate(getCurrentTime());
        p.setOwnerId(3);
        photoRepository.save(p);
        return "Saved";
    }

    @GetMapping("/listphotos")
    public @ResponseBody Iterable<Photo> listPhotos() {
        return photoRepository.findByUserId(3);
    }

    private static String getCurrentTime() {
        return DATEFORMAT.format(new java.util.Date());
    }


}