package lt.techin;

import lt.infobalt.itakademija.javalang.exam.socialnetwork.Friend;
import lt.infobalt.itakademija.javalang.exam.socialnetwork.FriendNotFoundException;
import lt.infobalt.itakademija.javalang.exam.socialnetwork.SocialNetwork;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.stream.Collectors;

public class SocialNetworkImpl implements SocialNetwork {

    private HashSet<Friend> friends;

    public SocialNetworkImpl() {
        this.friends = new HashSet<>();
    }

    @Override
    public void addFriend(Friend friend) {
        if (friend == null) {
            throw new IllegalArgumentException();
        }
        friends.add(friend);
    }


    @Override
    public int getNumberOfFriends() {
        return friends.size();
    }

    @Override
    public Friend findFriend(String firstName, String lastName) throws FriendNotFoundException {
        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException();
        }
        return friends.stream()
                .filter(n -> n.getFirstName().equals(firstName) && n.getLastName().equals(lastName))
                .findFirst()
                .orElseThrow(() -> new FriendNotFoundException(firstName, lastName));
    }

    @Override
    public Collection<Friend> findByCity(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        return friends.stream().filter(n -> n.getCity().equals(s)).collect(Collectors.toList());
    }

    @Override
    public Collection<Friend> getOrderedFriends() {
        return friends.stream().sorted(Comparator.comparing(Friend::getCity)
                        .thenComparing(Friend::getLastName)
                        .thenComparing(Friend::getFirstName))
                .collect(Collectors.toList());
    }
}
