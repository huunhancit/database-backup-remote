package com.codingandshare.dbbk.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * The class help config mail server.
 * Propose api for send the mail.
 *
 * @author Nhan Dinh
 * @since 6/11/21
 **/
@Configuration
@ConditionalOnProperty(value = "app.mailEnable", havingValue = "true")
public class MailConfiguration {

  @Autowired
  private MailProperties mailProperties;

  /**
   * The method create {@link Bean} for {@link JavaMailSender} interface.
   * Help to config connect to mail server.
   *
   * @return {@link JavaMailSender}
   */
  @Bean
  public JavaMailSender javaMailSender() {
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost(this.mailProperties.getServer());
    mailSender.setPort(this.mailProperties.getPort());
    mailSender.setUsername(this.mailProperties.getUsername());
    mailSender.setPassword(this.mailProperties.getPassword());
    Properties props = mailSender.getJavaMailProperties();
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.auth", this.mailProperties.getSmtpAuth());
    props.put("mail.smtp.starttls.enable",this.mailProperties.getSmtpTLS());
    props.put("mail.debug", "true");
    return mailSender;
  }
}
