package lt.techin;

import lt.infobalt.itakademija.javalang.exam.socialnetwork.BaseSocialNetworkTest;
import lt.infobalt.itakademija.javalang.exam.socialnetwork.SocialNetwork;

public class SocialNetworkTest extends BaseSocialNetworkTest {

    @Override
    protected SocialNetwork getSocialNetwork() {
        return new SocialNetworkImpl();
    }
}
