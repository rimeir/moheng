package moheng.member.domain;

import jakarta.persistence.*;
import moheng.global.entity.BaseEntity;

@Table(name = "member")
@Entity
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "nick_name", nullable = false)
    private String nickName;

    @Column(name = "profile_image_url", nullable = false)
    private String profileImageUrl;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "social_type", nullable = false)
    private SocialType socialType;

    protected Member() {
    }

    public Member(final String email, final String nickName,
                  final String profileImageUrl, final SocialType socialType) {
        validateEmail(email);
        validateNickName(nickName);
        validateProfileImageUri(profileImageUrl);
        validateSocialType(socialType);

        this.email = email;
        this.nickName = nickName;
        this.profileImageUrl = profileImageUrl;
        this.socialType = socialType;
    }

    private void validateEmail(final String email) {
    }

    private void validateNickName(final String displayName) {
    }

    private void validateProfileImageUri(final String profileImageUrl) {
    }

    private void validateSocialType(final SocialType socialType) {
    }
}
