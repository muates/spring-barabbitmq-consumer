package com.bilgeadam.springbarabbitmqconsumer.consumer;

import com.bilgeadam.springbarabbitmqconsumer.config.RabbitConfiguration;
import com.bilgeadam.springbarabbitmqconsumer.model.dto.Member;
import com.bilgeadam.springbarabbitmqconsumer.model.entity.MemberEntity;
import com.bilgeadam.springbarabbitmqconsumer.repository.MemberRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberConsumer {

    @Autowired
    private MemberRepository memberRepository;

    @RabbitListener(queues = RabbitConfiguration.QUEUE)
    public void saveMessage(Member member) {
        MemberEntity memberEntity = MemberEntity
                .builder()
                .firstName(member.getFirstName())
                .lastName(member.getLastName())
                .email(member.getEmail())
                .birthOfDate(member.getBirthOfDate())
                .build();

        memberRepository.save(memberEntity);

        System.out.println("İşlem başarılı bir şekilde tamamlandı");
    }
}
