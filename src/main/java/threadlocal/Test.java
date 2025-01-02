package threadlocal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    public static class Context {
        private String userName;

        public Context(String userName) {
            this.userName = userName;
        }
    }

    public static class SharedMapWithUserContext implements Runnable {

        public static Map<Integer, Context> userContextPerUserId = new ConcurrentHashMap<>();
        private Integer userId;

        public SharedMapWithUserContext(Integer userId) {
            this.userId = userId;
        }

        @Override
        public void run() {
            String userName = userId==1?"user1":"user2";
            userContextPerUserId.put(userId, new Context(userName));
        }
    }

    public static void main(String[] args) {
        SharedMapWithUserContext firstUser = new SharedMapWithUserContext(1);
        SharedMapWithUserContext secondUser = new SharedMapWithUserContext(2);
        new Thread(firstUser).start();
        new Thread(secondUser).start();

        System.out.println(SharedMapWithUserContext.userContextPerUserId);
    }
}

/*
- Static Field: Biến userContextPerUserId được khai báo là static, điều này có nghĩa là nó thuộc về lớp SharedMapWithUserContext,
chứ không phải riêng biệt cho từng đối tượng. Tất cả các thể hiện (instances) của lớp này sẽ chia sẻ cùng một biến userContextPerUserId.

- Concurrent Access: Khi bạn khởi tạo hai đối tượng của SharedMapWithUserContext và chạy chúng trong các luồng khác nhau,
cả hai luồng đều truy cập và cập nhật cùng một ConcurrentHashMap. Do đó, khi một luồng thêm một mục vào map, mục đó trở thành sẵn có cho cả hai luồng.
 */
