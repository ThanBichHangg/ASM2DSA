import java.util.LinkedList;
import java.util.Scanner;


class MessageSystem {
    static class Message {
        private final String content;

        public Message(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }
    }

    static class MessageQueue {
        private final LinkedList<Message> messages = new LinkedList<>();

        public void enqueueMessage(Message message) {
            messages.addLast(message);
        }

        public Message dequeueMessage() {
            return messages.poll();
        }

        public boolean isEmpty() {
            return messages.isEmpty();
        }
    }

    static class MessageStack {
        private final LinkedList<Message> messages = new LinkedList<>();

        public void pushMessage(Message message) {
            messages.push(message);
        }

        public Message popMessage() {
            return messages.pop();
        }

        public boolean isEmpty() {
            return messages.isEmpty();
        }
    }

    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue();
        MessageStack messageStack = new MessageStack();

        Scanner scanner = new Scanner(System.in);

        // Nhập tin nhắn từ người dùng và xử lý
        while (true) {
            System.out.println("Nhap tin nhan (hoac an 'q' de thoat): ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("q")) {
                break;
            }

            processUserMessage(userInput, messageQueue, messageStack);
        }

        // Hiển thị tin nhắn từ ngăn xếp
        displayUserMessages(messageStack);

        // Đóng Scanner sau khi sử dụng
        scanner.close();
    }

    private static void processUserMessage(String userInput, MessageQueue messageQueue, MessageStack messageStack) {
        if (userInput.length() <= 250) {
            Message receivedMessage = new Message(userInput);
            messageQueue.enqueueMessage(receivedMessage);
            messageStack.pushMessage(receivedMessage);
            System.out.println("Tin nhan da nhan: " + userInput);
        } else {
            System.out.println("Invalid message: Tin nhan khong vuot qua 250 ky tu");
        }
    }

    private static void displayUserMessages(MessageStack messageStack) {
        System.out.println("\nHien thi tin nhan của nguoi dung:");
        while (!messageStack.isEmpty()) {
            Message message = messageStack.popMessage();
            System.out.println("Tin nhan cua nguoi dung: " + message.getContent());
        }
    }
}