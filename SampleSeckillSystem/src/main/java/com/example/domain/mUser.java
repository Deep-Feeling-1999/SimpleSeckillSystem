package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @author Deep-Feeling-1999
 * @create 2021/1/4
 */
@Data
@Repository
@NoArgsConstructor
@AllArgsConstructor
public class mUser {
    private String uAccount;
    private String uPassWord;
}
