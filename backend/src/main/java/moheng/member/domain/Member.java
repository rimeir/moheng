package moheng.member.domain;

import jakarta.persistence.*;
import moheng.global.entity.BaseEntity;
import moheng.member.exception.*;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Table(name = "member")
@Entity
public class Member extends BaseEntity {
    private static final Pattern EMAIL_FORMAT = Pattern.compile("^[a-z0-9._-]+@[a-z]+[.]+[a-z]{2,3}$");
    private static final int MAX_NICK_NAME_LENGTH = 50;
    private static final int MIN_NICK_NAME_LENGTH = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "profile_image_url")
    private String profileImageUrl;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "social_type", nullable = false)
    private SocialType socialType;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "gender_type")
    private GenderType genderType;

    protected Member() {
    }

    public Member(final String email, final SocialType socialType) {
        validateEmail(email);
        this.email = email;
        this.socialType = socialType;
    }

    public Member(final Long id, final String email, final String nickName,
                  final String profileImageUrl, final SocialType socialType,
                  final LocalDate birthday, final GenderType genderType) {
        validateNickName(nickName);
        validateGenderType(genderType);
        validateBirthday(birthday);
        validateSocialType(socialType);

        this.id = id;
        this.email = email;
        this.nickName = nickName;
        this.profileImageUrl = profileImageUrl;
        this.socialType = socialType;
        this.birthday = birthday;
        this.genderType = genderType;
    }

    private void validateEmail(final String email) {
        Matcher matcher = EMAIL_FORMAT.matcher(email);
        if (!matcher.matches()) {
            throw new InvalidEmailFormatException("이메일 형식이 올바르지 않습니다.");
        }
    }

    private void validateNickName(final String displayName) {
        if (displayName.isEmpty() || displayName.length() < MIN_NICK_NAME_LENGTH ||
                displayName.length() > MAX_NICK_NAME_LENGTH) {
            throw new InvalidNicknameFormatException(String.format("이름은 %d자 이상 1자 %d이하여야 합니다.",  MIN_NICK_NAME_LENGTH, MAX_NICK_NAME_LENGTH));
        }
    }

    private void validateSocialType(final SocialType socialType) {
        if(!SocialType.isMatches(socialType)) {
            throw new NoExistSocialTypeException("존재하지 않는 소셜 로그인 제공처입니다.");
        }
    }

    private void validateBirthday(final LocalDate birthday) {
        if(birthday.isAfter(LocalDate.now())) {
            throw new InvalidBirthdayException("생년월일은 현재 날짜보다 더 이후일 수 없습니다.");
        }
    }

    private void validateGenderType(final GenderType genderType) {
        if(!GenderType.isMatches(genderType)) {
            throw new InvalidGenderFormatException("유효하지 않은 성별 입니다.");
        }
    }

    public Long getId() {
        return id;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public GenderType getGenderType() {
        return genderType;
    }

    public String getNickName() {
        return nickName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
