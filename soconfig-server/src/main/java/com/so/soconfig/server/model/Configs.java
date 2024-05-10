package com.so.soconfig.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * base configs definition
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-05-10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Configs {
    private String app;
    private String env;
    private String ns;
    private String pkey;
    private String pval;
}
