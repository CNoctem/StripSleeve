package konishi.ssleeve;

import konishi.ssleeve.data.Album;
import konishi.ssleeve.data.User;
import konishi.ssleeve.data.repo.AlbumRepository;
import konishi.ssleeve.data.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProfileController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping(path="/activeprofile")
    public @ResponseBody User getActiveUser() {
        return userRepository.getById(3);
    }

    @GetMapping(path="/listalbums")
    public @ResponseBody Iterable<Album> listAlbums() {
        return albumRepository.getByUserId(3);
    }


}
