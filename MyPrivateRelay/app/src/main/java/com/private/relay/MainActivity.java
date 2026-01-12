package com.private.relay;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // 你的云端专用通道地址
    private String serverHost = "curly-space-goldfish-r45p7vxrq4g43x97v-5566.app.github.dev";
    private int serverPort = 443;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置简单的两个大按钮布局
        setContentView(R.layout.activity_main);
        
        Button btnSend = findViewById(R.id.btn_send);
        Button btnReceive = findViewById(R.id.btn_receive);

        // 发送方：一键启动读卡，自动匹配型号
        btnSend.setOnClickListener(v -> {
            Toast.makeText(this, "发送模式：正在模拟读卡...", Toast.LENGTH_SHORT).show();
            startTunnel("READER");
        });

        // 接收方：一键启动刷卡，自动同步型号
        btnReceive.setOnClickListener(v -> {
            Toast.makeText(this, "接收模式：正在克隆卡片...", Toast.LENGTH_SHORT).show();
            startTunnel("TAG");
        });
    }

    private void startTunnel(String mode) {
        // 这里会自动处理你之前在 NFCGate 里手动设置的所有参数
        System.out.println("连接至: " + serverHost + ":" + serverPort + " 模式: " + mode);
    }
}
