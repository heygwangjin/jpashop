# jpashop

### TIL
1. 두 테이블이 양방향 관계일 때, 연관관계 주인을 설정해야 한다. 일반적으로, 외래 키(FK)가 있는 곳을 연관관계 주인으로 정하는게 좋다. 연관관계 주인 필드에는 @OneToOne, @ManyToOne 과 같은 애너테이션을 붙이고, @JoinColumn을 통해서 FK 매핑을 한다. 그리고 관계를 맺고 있는 테이블의 필드에 mappedBy를 통해 거울을 설정한다.
2. 일대다 관계에서 항상 다쪽에 외래 키가 있으므로 외래 키가 있는 엔티티를 연관관계의 주인으로 정하면 된다.
3. SQL은 테이블을 대상으로 쿼리를 날리지만, JPQL은 엔티티 객체를 대상으로 쿼리를 날린다.
4. 테스트 코드 수행 시, test/resources/application.yml이 java/resources/application.yml 보다 우선권을 가진다.