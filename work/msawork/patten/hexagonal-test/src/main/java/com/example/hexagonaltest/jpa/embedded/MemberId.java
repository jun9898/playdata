package com.example.hexagonaltest.jpa.embedded;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class MemberId {
    private String id;
    // UUID 로 id를 생성하고 MemberID 객체를 만들어서 리턴하는 메소드
    public static MemberId createMemberId(){
        UUID uuid = UUID.randomUUID();
        String year = String.valueOf(LocalDate.now().getYear());
        String str = year + "-" + uuid;
        MemberId memberId= new MemberId();
        memberId.setId(str);
        return memberId;
    }

    public static MemberId getMemberId(){
        return MemberId.createMemberId();
    }

    public static void main(String[] args) {
        System.out.println(MemberId.getMemberId());
    }
}
