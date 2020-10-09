import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 性能非常糟糕
 */
abstract class SingleThreadWebServer {
    public void main() throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            Socket accept = socket.accept();
            handleRequest(accept);
        }
    }

    public abstract void handleRequest(Socket socket);
}

/**
 * 无限制创建线程
 * 线程生命周期的开销非常高
 * 资源消耗大
 * 稳定性差
 */
abstract class ThreadPerTaskWebServer {
    public void main() throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket accept = socket.accept();
            new Thread(() -> handleRequest(accept)).start();
        }
    }

    public abstract void handleRequest(Socket socket);
}

/**
 * @author YuJian
 * @description 在线程中执行任务
 * @since 2020/10/9
 */
public class Section1 {
}
