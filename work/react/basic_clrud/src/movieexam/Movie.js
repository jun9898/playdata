//영화 하나에 대한 정보를 카드로 디자인
export default function Movie({ movieId, title, alt, url, genre }) {
  return (
    //카드 한 장에 대한 정보로 뷰를 만들기 - 데이터는 속성으로 받아서 처리
    <div
      className="col-sm-3"
      onClick={function (event) {
        event.preventDefault();
        alert(title);
      }}
    >
      <div className="thumbnail">
        <p>{title}</p>
        <img src={url} alt={alt} />
        <p>{genre}</p>
      </div>
    </div>
  );
}