package dao;

import entity.Comment;

import java.io.IOException;
import java.util.List;

public interface CommentDAO {

    void createComment(Comment comment) throws IOException;

    List<Comment> getCommentListByClaimId(Integer claimId) throws IOException;

    List<Comment> getCommentListByClaimCode(Integer claimCode) throws IOException;

    List<Comment> getCommentListByWorkorderId(Integer workorderId) throws IOException;

    List<Comment> getCommentListByWorkorderCode(Integer workorderCode) throws IOException;

}
