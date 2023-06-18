package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();   //저장공간 store
    private static long sequence = 0L;              //key 값 0, 1, 2, ...

    @Override
    public Member save(Member member) {
        member.setId(++sequence);   //key값을 1 올려주며 id 설정
        store.put(member.getId(), member);

        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));  //데이터가 NULL인 경우를 대비하여 Optional 사용함
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))    //파라미터로 받은 name과 동일한 경우에만 filter됨
                .findAny(); //찾으면 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    //테스트시 메모리 DB에 저장된 데이터를 삭제하기 위한 것
    public void clearStore(){
        store.clear();
    }
}
