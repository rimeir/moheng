package moheng.member.domain;

public enum SocialType {
    KAKAO, GOOGLE;

    public static boolean isMatches(SocialType input) {
        for(SocialType type : SocialType.values()) {
            if(type == input) return true;
        }
        return false;
    }
}
