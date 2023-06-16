package miu.edu.upvote;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Upvote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long articleId;

    private Long userId;

    private Date created_at;

    @PrePersist
    protected void onCreate() {
        created_at = new Date();
    }

}
