package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

/**
 * @author Deep-Feeling-1999
 * @create 2021/1/4
 */
@Data
@Repository
@NoArgsConstructor
@AllArgsConstructor
public class mOrder {
    private int oId;
    private String uAccount;
    private LocalDateTime oDate;
}
