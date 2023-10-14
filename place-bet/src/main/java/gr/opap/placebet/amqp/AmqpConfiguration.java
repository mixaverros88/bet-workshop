package gr.opap.placebet.amqp;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfiguration {

  public static final String USER_EMAIL_VERIFICATION = "user.email.verification";
  public static final String USER_SMS_VERIFICATION = "user.sms.verification";
  public static final String USER_FORGOT_PASSWORD = "user.forgot.password";
  public static final String USER_SEND_REMINDER_FOR_EMAIL_VERIFICATION = "user.send.reminder.for.email.verification";
  public static final String USER_SEND_REMINDER_FOR_PHONE_VERIFICATION = "user.send.reminder.for.phone.verification";
  public static final String INFORM_FOR_THERAPY_CANCELLATION = "inform.for.therapy.cancellation";
  public static final String THERAPY_REMINDER = "therapy.reminder";

  @Bean
  @Qualifier("therapyReminderQueue")
  Queue therapyReminderQueue() {
    return new Queue(THERAPY_REMINDER, false);
  }

  @Bean
  @Qualifier("therapyReminderExchange")
  DirectExchange therapyReminderExchange() {
    return new DirectExchange(THERAPY_REMINDER);
  }

  @Bean
  Binding itherapyReminderBinding(
      @Qualifier("therapyReminderQueue") Queue queue,
      @Qualifier("therapyReminderExchange") DirectExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with(THERAPY_REMINDER);
  }


  @Bean
  @Qualifier("informForTherapyCancellationQueue")
  Queue informForTherapyCancellationQueue() {
    return new Queue(INFORM_FOR_THERAPY_CANCELLATION, false);
  }

  @Bean
  @Qualifier("informForTherapyCancellationExchange")
  DirectExchange informForTherapyCancellationExchange() {
    return new DirectExchange(INFORM_FOR_THERAPY_CANCELLATION);
  }

  @Bean
  Binding informForTherapyCancellationBinding(
      @Qualifier("informForTherapyCancellationQueue") Queue queue,
      @Qualifier("informForTherapyCancellationExchange") DirectExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with(INFORM_FOR_THERAPY_CANCELLATION);
  }


  @Bean
  @Qualifier("userSendReminderForPhoneVerificationQueue")
  Queue userSendReminderForPhoneVerificationQueue() {
    return new Queue(USER_SEND_REMINDER_FOR_PHONE_VERIFICATION, false);
  }

  @Bean
  @Qualifier("userSendReminderForPhoneVerificationExchange")
  DirectExchange userSendReminderForPhoneVerificationExchange() {
    return new DirectExchange(USER_SEND_REMINDER_FOR_PHONE_VERIFICATION);
  }

  @Bean
  Binding userSendReminderForPhoneVerificationBinding(
      @Qualifier("userSendReminderForPhoneVerificationQueue") Queue queue,
      @Qualifier("userSendReminderForPhoneVerificationExchange") DirectExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with(USER_SEND_REMINDER_FOR_PHONE_VERIFICATION);
  }


  @Bean
  @Qualifier("userSendReminderForEmailVerificationQueue")
  Queue userSendReminderForEmailVerificationQueue() {
    return new Queue(USER_SEND_REMINDER_FOR_EMAIL_VERIFICATION, false);
  }

  @Bean
  @Qualifier("userSendReminderForEmailVerificationExchange")
  DirectExchange userSendReminderForEmailVerificationExchange() {
    return new DirectExchange(USER_SEND_REMINDER_FOR_EMAIL_VERIFICATION);
  }

  @Bean
  Binding userSendReminderForEmailVerificationBinding(
      @Qualifier("userSendReminderForEmailVerificationQueue") Queue queue,
      @Qualifier("userSendReminderForEmailVerificationExchange") DirectExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with(USER_SEND_REMINDER_FOR_EMAIL_VERIFICATION);
  }


  @Bean
  @Qualifier("userForgotPasswordQueue")
  Queue userForgotPasswordQueue() {
    return new Queue(USER_FORGOT_PASSWORD, false);
  }

  @Bean
  @Qualifier("userForgotPasswordExchange")
  DirectExchange userForgotPasswordExchange() {
    return new DirectExchange(USER_FORGOT_PASSWORD);
  }

  @Bean
  Binding userForgotPasswordBinding(@Qualifier("userForgotPasswordQueue") Queue queue,
      @Qualifier("userForgotPasswordExchange") DirectExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with(USER_FORGOT_PASSWORD);
  }


  @Bean
  @Qualifier("userEmailVerificationQueue")
  Queue userEmailVerificationQueue() {
    return new Queue(USER_EMAIL_VERIFICATION, false);
  }

  @Bean
  @Qualifier("userEmailVerificationExchange")
  DirectExchange userEmailVerificationExchange() {
    return new DirectExchange(USER_EMAIL_VERIFICATION);
  }

  @Bean
  Binding userEmailVerificationBinding(@Qualifier("userEmailVerificationQueue") Queue queue,
      @Qualifier("userEmailVerificationExchange") DirectExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with(USER_EMAIL_VERIFICATION);
  }


  @Bean
  @Qualifier("userSmsVerificationQueue")
  Queue userSmsVerificationQueue() {
    return new Queue(USER_SMS_VERIFICATION, false);
  }

  @Bean
  @Qualifier("userSmsVerificationExchange")
  DirectExchange userSmsVerificationExchange() {
    return new DirectExchange(USER_SMS_VERIFICATION);
  }

  @Bean
  Binding userSmsVerificationBinding(@Qualifier("userSmsVerificationQueue") Queue queue,
      @Qualifier("userSmsVerificationExchange") DirectExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with(USER_SMS_VERIFICATION);
  }


  // You can comment the two methods below to use the default serialization / deserialization (instead of JSON)
  @Bean
  public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
    RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
    return rabbitTemplate;
  }

  @Bean
  public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
    return new Jackson2JsonMessageConverter();
  }
}
