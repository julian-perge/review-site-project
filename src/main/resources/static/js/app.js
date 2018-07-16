const reviewTags = document.querySelector('.review-tags');

// Create event listener


// // Created another function for handling the state change
function stateChange(response) {
  // console.log(response);
  // console.log(response.currentTarget);
  // console.log(response.currentTarget.response);
  if (this.readyState === 4 && this.status === 200) {
    const remainingTags = JSON.parse(response.currentTarget.response);
    let list = '';
    remainingTags.forEach((tag) => {
      // `abbreviation` and `cityId` reference lines 16 & 17
      list += `
            <li>
              <a href="/tags/${tag.name}">
                ${tag.name}
              </a>
              <!-- Create a .delete button -->
              <button class="delete">Remove</button>
            </li>
          `;
    });
    reviewTags.innerHTML = list;
  }
}
// Create a function to remove a tag
// event parameter passed in being the element that is being clicked
// e.g. the paragraph tag, h3, button, span, etc...
function removeTag(event) {
  if (event.target.classList.contains('delete')) {
    // Select delete button
    // --The event is the click event,
    // --and it is targeting the delete button because it's class contains 'delete'
    const deleteButton = event.target;
    // Traverse to city container
    // --Finding the parent element of the button
    const tagContainer = deleteButton.parentElement;
    // Get 'href' attribute from link
    const urlArray = document.URL.split('/');
    const hrefArray = tagContainer.querySelector('a').getAttribute('href').split('/');
    // Get tagName from hrefArray
    const tagName = hrefArray[2];
    // Set up action for response
    const xhr = new XMLHttpRequest();
    // Repopulate list with existing cities (pass response as a parameter)
    xhr.addEventListener('readystatechange', stateChange);
    if (urlArray.includes('reviews')) {
      const title = urlArray[4];
      xhr.open('DELETE', `/api/reviews/${title}/${tagName}`, true);
    } else {
      xhr.open('DELETE', `/api/tags/${tagName}`, true);
    }
    xhr.send();
  }
}
reviewTags.addEventListener('click', removeTag);