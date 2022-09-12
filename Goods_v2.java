package kr.co.checkpoint;
/*
 * 
[상품정보] Goods
- 상품번호,상품명,가격,제조국가
- gNo, gName, gPrice, gMake
- 생성자 4개 필드 작성
- getter, setter작성
- tostring작성
----------
GoodsControl.java
1 초기화 하여 배열에 상품 5개 등록함

[메뉴]
1.상품추가 2.상품수정. 3. 상품삭제
4.상품보기 5. 종료

상품추가/수정/삭제하기 전 있는 품목인지 파악후 동작

필요한 메소스드들 : 상품추가하기, 상품수정하기, 상품 삭제하기, 상품보기, 상품검색

 */

public class Goods_v2 {
	private int gNo;
	private String gName;
	private int gPrice;
	private String gMake;
	
	public Goods_v2() {
		// TODO Auto-generated constructor stub
	}

	public Goods_v2(int gNo, String gName, int gPrice, String gMake) {
		super();
		this.gNo = gNo;
		this.gName = gName;
		this.gPrice = gPrice;
		this.gMake = gMake;
	}

	public int getgNo() {
		return gNo;
	}

	public void setgNo(int gNo) {
		this.gNo = gNo;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public int getgPrice() {
		return gPrice;
	}

	public void setgPrice(int gPrice) {
		this.gPrice = gPrice;
	}

	public String getgMake() {
		return gMake;
	}

	public void setgMake(String gMake) {
		this.gMake = gMake;
	}

	@Override
	public String toString() {
		return "Goods [gNo=" + gNo + ", gName=" + gName + ", gPrice=" + gPrice + ", gMake=" + gMake + "]";
	}
	
	
	

}
