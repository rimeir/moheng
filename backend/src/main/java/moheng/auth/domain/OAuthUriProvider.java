package moheng.auth.domain;

@FunctionalInterface
public interface OAuthUriProvider {
    String generateUri();
}
