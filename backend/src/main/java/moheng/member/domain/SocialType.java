package moheng.member.domain;

public enum SocialType {
    KAKAO, GOOGLE;

    public static boolean isMatches(String input) {
        for (SocialType type : SocialType.values()) {
            if (type.name().equalsIgnoreCase(input)) {
                return true;
            }
        }
        return false;
    }
}
