package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Dialog {

    private int dialogId;
    List<Post> postList;
//    private List<Integer> allPosts;

}
