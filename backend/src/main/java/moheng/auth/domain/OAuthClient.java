package moheng.auth.domain;

@FunctionalInterface
public interface OAuthClient {
    OAuthMember getOAuthmember(final String code);
}
