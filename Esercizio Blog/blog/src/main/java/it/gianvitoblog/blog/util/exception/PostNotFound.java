package it.gianvitoblog.blog.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Author not found")
public class PostNotFound extends RuntimeException{
    
}
