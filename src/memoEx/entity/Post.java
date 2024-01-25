package memoEx.entity;

import java.util.*;

public class Post {
    private int postLength = 0;                 // 게시글의 갯수
//    private List<PostEntity> postEntities = new ArrayList<>();          // final 삭제처리 해버림
private List<PostEntity> postEntities = new LinkedList<>();
    private final int POST_SIZE = 20;           // 게시글의 최대 저장 갯수

//    public Post(){
//        this.postEntities = new PostEntity[POST_SIZE];
//    }

    public void write(){
        System.out.println("");
        if (POST_SIZE == this.postLength){
            System.out.println("게시글 저장 공간이 꽉 찼습니다.");
            System.out.println("");
            return;
        }
        System.out.println("게시글을 작성합니다.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("글 제목을 작성해주세요.");
        String title = scanner.nextLine();

        System.out.println("글 내용을 작성해주세요.");
        String content = scanner.nextLine();

//        postEntities[this.postLength++] = PostEntity.newInstance(title, content);
        postEntities.add(PostEntity.newInstance(title, content));

        System.out.println("게시글이 작성되었습니다.");
        System.out.println("");
    }

    public void printAllPosts(){
        System.out.println("");
//        if( this.postLength == 0){
        if(postEntities.get(0).getTitle() == null){
            System.out.println("조회할 수 있는 게시글이 없습니다.");
            System.out.println("");
            return;
        }

//        for (int i = 0; i < this.postLength; i++){
        for(int i = 0; i < postEntities.size(); i++){
//            PostEntity postEntity = postEntities[i];
            PostEntity postEntity = postEntities.get(i);
            System.out.println(postEntity);

            String headLine = String.format("게시글 번호: %d 게시글 제목: %s 작성일: %s", i, postEntity.getTitle(), postEntity.getLastUpdatedDateTime());
            System.out.println(headLine);
        }

        for(int i = 0; i < postEntities.size(); i++){
            System.out.println(postEntities.get(i).getTitle() +" / "+ postEntities.get(i).getContent());
        }

        System.out.println("");
    }

    public void printPost(){
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        System.out.println("조회할 게시글의 번호를 입력하세요");
        int selectedPost = scanner.nextInt();
//        PostEntity postEntity = postEntities[selectedPost];
        PostEntity postEntity = postEntities.get(selectedPost);
        if (postEntity == null){
            System.out.println("작성된 글이 없습니다.");
            System.out.println("");
            return;
        }
        System.out.println("");
        String headline = String.format("번호: %d 제목: %s", selectedPost, postEntity.getTitle());
        System.out.println(headline);
        System.out.println(postEntity.getLastUpdatedDateTime());
        System.out.println(postEntity.getContent());
        System.out.println("");
    }

    public void updatePost(){
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        System.out.println("게시글을 수정합니다.");
        System.out.println("수정할 게시글의 번호를 입력해주세요.");
        int selectedPost = Integer.parseInt(scanner.nextLine());

        System.out.println("게시글을 작성해주세요");
        String content = scanner.nextLine();

//        PostEntity postEntity = postEntities[selectedPost];
        PostEntity postEntity = postEntities.get(selectedPost);
        if ( postEntity == null ){
            System.out.println("존재하지 않는 글입니다.");
            return;
        }
        postEntity.update(content);

        System.out.println("게시글이 수정되었습니다.");
        System.out.println("");

    }

    public void deletePost(){
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        System.out.println("삭제할 게시글을 선택해주세요");
        int selectedPost = Integer.parseInt(scanner.nextLine());

        postEntities.remove(selectedPost);

//        ArrayList<PostEntity> postList = new ArrayList<>(Arrays.asList(postEntities));
//        postList.remove(selectedPost);
//        this.postEntities = new PostEntity[--postLength];
//        postEntities = postList.toArray(PostEntity[]::new);


    }
}
