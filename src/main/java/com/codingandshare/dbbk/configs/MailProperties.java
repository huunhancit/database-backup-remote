package com.codingandshare.dbbk.configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * The class load all configs for mail server.
 * The prefix properties is app.mail.
 * The class initial instance when app.mail.enable is true.
 *
 * @author Nhan Dinh
 * @since 6/11/21
 **/
@Setter
@Getter
@Configuration
@ConditionalOnProperty(value = "app.mailEnable", havingValue = "true")
@ConfigurationProperties(prefix = "app.mail")
public class MailProperties {

  private String server;

  private Integer port;

  private String username;

  private String password;

  private Boolean smtpAuth;

  private Boolean smtpTLS;

  private Boolean smtpTLSRequired;
}
