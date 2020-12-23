package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private int idPost;
    private int idDialog;
    private int idUser;
    private int idReceiver;
    private String post;
    private String stringDate;
    private long postTime;

    public Post(int idUser, String post) {
        this.idUser = idUser;
        this.post = post;
    }

    public Post(int idPost, int idDialog, int idUser, int idSender, String post, String stringDate) {
        this.idPost = idPost;
        this.idDialog = idDialog;
        this.idUser = idUser;
        this.idReceiver = idReceiver;
        this.post = post;
        this.stringDate = stringDate;
    }

    public Post(int idUser, int idReceiver, String post) {
        this.idUser = idUser;
        this.idReceiver = idReceiver;
        this.post = post;
    }
}
