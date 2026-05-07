package com.test.enumtest;

// HTTP 프로토콜 맛보기용 응답코드
public enum ResponseCode {

    // 1. 상수 선언(세미콜론을 마지막에 쓰기 때문에 상수 선언)
    // 코드번호, 메세지, 성공여부
    SUCCESS(200, "성공적으로 처리되었습니다.", true),
    BAD_REQUEST(400, "잘못된 요청입니다.", false),
    NOT_FOUND(404, "페이지를 찾을 수 없습니다.", false),
    SERVER_ERROR(500, "서버 내부 오류가 발생하였습니다.", false);

    // 2. 인스턴스 변수 선언
    private final int code;
    private final String message;
    private final boolean isSuccess;

    // 3. 생성자
    ResponseCode(int i, String string, boolean b) {
        //TODO Auto-generated constructor stub
        this.code = i;
        this.message = string;
        this.isSuccess = b;
    }    

    // 4. getter
    public int getCode(){return code;}
    public String getMessage(){return message;}
    public boolean getIsSuccess(){return isSuccess;}
}
