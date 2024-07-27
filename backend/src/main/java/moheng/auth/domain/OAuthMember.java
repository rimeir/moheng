package moheng.auth.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OAuthMember {
    @JsonProperty("id")
    private String socialLoginId;

    @JsonProperty("kakao_account")
    private KakaoAccount kakaoAccount;

    private class KakaoAccount {
        @JsonProperty("profile")
        private KakaoProfile kakaoProfile;

        @JsonProperty("email")
        private String email;
    }

    private class KakaoProfile {
        @JsonProperty("nickname")
        private String nickname;

        @JsonProperty("profile_image_url")
        private String image;
    }

    public OAuthMember(String email, String socialLoginId, String nickname, String imageurl) {
        this.socialLoginId = socialLoginId;
        this.kakaoAccount = new KakaoAccount();
        this.kakaoAccount.email = email;
        this.kakaoAccount.kakaoProfile = new KakaoProfile();
        this.kakaoAccount.kakaoProfile.nickname = nickname;
        this.kakaoAccount.kakaoProfile.image = imageurl;
    }

    public String getSocialLoginId() {
        return socialLoginId;
    }

    public String getNickname() {
        return kakaoAccount.kakaoProfile.nickname;
    }

    public String getImageUrl() {
        return kakaoAccount.kakaoProfile.image;
    }

    public String getEmail() {
        return kakaoAccount.email;
    }
}

