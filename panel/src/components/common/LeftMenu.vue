<template>

  <button data-drawer-target="logo-sidebar" data-drawer-toggle="logo-sidebar" aria-controls="logo-sidebar" type="button" class="inline-flex items-center p-2 mt-2 ml-3 text-sm text-gray-500 rounded-lg sm:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600">
    <span class="sr-only">Open sidebar</span>
    <svg class="w-6 h-6" aria-hidden="true" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
      <path clip-rule="evenodd" fill-rule="evenodd" d="M2 4.75A.75.75 0 012.75 4h14.5a.75.75 0 010 1.5H2.75A.75.75 0 012 4.75zm0 10.5a.75.75 0 01.75-.75h7.5a.75.75 0 010 1.5h-7.5a.75.75 0 01-.75-.75zM2 10a.75.75 0 01.75-.75h14.5a.75.75 0 010 1.5H2.75A.75.75 0 012 10z"></path>
    </svg>
  </button>

  <aside id="logo-sidebar" class="fixed top-0 left-0 z-40 w-64 h-screen transition-transform -translate-x-full sm:translate-x-0" aria-label="Sidebar">
    <div class="h-full px-3 py-4 overflow-y-auto bg-gray-50 dark:bg-gray-800 ">
      <a href="/" class="flex justify-center items-center pl-2.5 mb-5">
        <svg height="100" viewBox="33.6 130.6 499.7 242.9" width="100" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"><linearGradient id="a"><stop offset=".085" stop-color="#469e43"/><stop offset="1" stop-color="#132d13"/></linearGradient><linearGradient id="b" gradientUnits="userSpaceOnUse" x1="64.863" x2="64.863" xlink:href="#a" y1="288.291" y2="369.4"/><linearGradient id="c" gradientUnits="userSpaceOnUse" x1="138.367" x2="138.367" xlink:href="#a" y1="308.454" y2="370.601"/><linearGradient id="d" gradientUnits="userSpaceOnUse" x1="195.475" x2="195.475" xlink:href="#a" y1="288.291" y2="369.85"/><linearGradient id="e" gradientUnits="userSpaceOnUse" x1="249.634" x2="249.634" xlink:href="#a" y1="307.312" y2="369.511"/><linearGradient id="f" gradientUnits="userSpaceOnUse" x1="302.884" x2="302.884" xlink:href="#a" y1="288.291" y2="367.857"/><linearGradient id="g" gradientUnits="userSpaceOnUse" x1="354.118" x2="354.118" xlink:href="#a" y1="307.312" y2="369.511"/><linearGradient id="h" gradientUnits="userSpaceOnUse" x1="428.02" x2="428.02" xlink:href="#a" y1="306.156" y2="367.742"/><linearGradient id="i" gradientUnits="userSpaceOnUse" x1="502.066" x2="502.066" xlink:href="#a" y1="288.291" y2="369.4"/><linearGradient id="j" gradientUnits="userSpaceOnUse" x1="283.264" x2="283.264" xlink:href="#a" y1="131.629" y2="232.559"/><linearGradient id="k" gradientUnits="userSpaceOnUse" x1="283.46" x2="283.46" y1="202.275" y2="183.785"><stop offset="0" stop-color="#969799" stop-opacity="0"/><stop offset="1" stop-color="#808183"/></linearGradient><path d="m65 307.2c-6.8 0-13.1 2.2-18.2 5.9v-24.8h-13.2v81.1h31.4c17.2 0 31.1-13.9 31.1-31.1s-13.9-31.1-31.1-31.1zm0 49.3h-18.2v-18.2c0-10.1 8.2-18.2 18.2-18.2 10.1 0 18.2 8.2 18.2 18.2.1 10.1-8.1 18.2-18.2 18.2z" fill="url(#b)"/><path d="m168.8 343.9h-46.7c1.4 7.1 6.6 12 14.1 12.7 6.4.6 12.9.1 19.9.1v11.9c-15.2 4.9-33.3.5-42.1-10.4-3.8-4.7-17.3-34.7 11.5-47.4 39-11.4 45.3 22.4 43.3 33.1zm-14.2-12.7c-1.7-8.1-8.8-12.9-17.9-12.3-7.6.5-14 5.8-14.5 12.3z" fill="url(#c)"/><path d="m195.5 320.2c0 10.5-.2 20 .1 29.6.2 5.8 4.4 8.4 13.2 8.6v10.5c-13.8 3.9-26.2-4.5-26.4-18-.2-18.7-.1-43.9-.1-62.6h14.1l-.3 18.5 12.7-.1v13.4h-13.3z" fill="url(#d)"/><path d="m249.6 307.3c-17.2 0-31.1 13.9-31.1 31.1s13.9 31.1 31.1 31.1h31.1v-31.1c0-17.2-13.9-31.1-31.1-31.1zm18.6 49.7h-18.5c-10.2 0-18.5-8.3-18.5-18.5s8.3-18.5 18.5-18.5 18.5 8.3 18.5 18.5z" fill="url(#e)"/><path d="m296.4 288.3h13v79.6h-13z" fill="url(#f)"/><path d="m354.1 307.3c-17.2 0-31.1 13.9-31.1 31.1s13.9 31.1 31.1 31.1h31.1v-31.1c0-17.2-13.9-31.1-31.1-31.1zm18.6 49.7h-18.5c-10.2 0-18.5-8.3-18.5-18.5s8.3-18.5 18.5-18.5 18.5 8.3 18.5 18.5z" fill="url(#g)"/><path d="m442.2 367.7c0-12.3.2-23.6 0-34.9-.2-3.4-3.6-13.8-14.1-13.4-10.3-.3-14.4 10-14.3 12.7.1 10.2.5 35.1.5 35.1l-13.6.1s-.3-25.7.2-36.2c.6-14.1 12.7-25 27.5-25 14.7 0 26.2 10.4 26.7 24.9.4 10.4.5 36.3.5 36.3z" fill="url(#h)"/><path d="m501.9 307.2c6.8 0 13.1 2.2 18.2 5.9v-24.8h13.2v81.1h-31.4c-17.2 0-31.1-13.9-31.1-31.1s13.9-31.1 31.1-31.1zm0 49.3h18.2v-18.2c0-10.1-8.2-18.2-18.2-18.2-10.1 0-18.2 8.2-18.2 18.2 0 10.1 8.1 18.2 18.2 18.2z" fill="url(#i)"/><path d="m309.2 180.6h-24v-24c0-12.6 10.2-24.1 22.8-25 14.8-1 27.1 11.3 26.1 26.1-.8 12.7-12.3 22.9-24.9 22.9zm-50.7-48.9c-14.8-1-27.1 11.3-26.1 26.1.8 12.6 12.4 22.8 25 22.8h23.9v-24c0-12.6-10.3-24.1-22.8-24.9zm50.7 51.9h-24v23.9c0 12.6 10.2 24.1 22.8 25 14.8 1 27.1-11.3 26.1-26.1-.8-12.6-12.3-22.8-24.9-22.8zm-52.4 0c-14 0-25.3 11.8-24.4 26 .8 12.2 10.7 22.1 22.9 22.9 14.2.9 26-10.4 26-24.4v-24.5z" fill="url(#j)"/><path d="m281.7 183.8h3.6v18.5h-3.6z" fill="url(#k)"/></svg>
      </a>
      <ul class="space-y-2 font-medium">
        <li>
          <router-link to="/bets" class="flex items-center p-2 text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group">
            <svg class="w-5 h-5 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 22 21">
              <path d="M16.975 11H10V4.025a1 1 0 0 0-1.066-.998 8.5 8.5 0 1 0 9.039 9.039.999.999 0 0 0-1-1.066h.002Z"/>
              <path d="M12.5 0c-.157 0-.311.01-.565.027A1 1 0 0 0 11 1.02V10h8.975a1 1 0 0 0 1-.935c.013-.188.028-.374.028-.565A8.51 8.51 0 0 0 12.5 0Z"/>
            </svg>
            <span class="ml-3">Bets</span>
          </router-link>
        </li>
        <li>
          <router-link to="/mocks" class="flex items-center p-2 text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group">
            <svg class="flex-shrink-0 w-5 h-5 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 18 18">
              <path d="M6.143 0H1.857A1.857 1.857 0 0 0 0 1.857v4.286C0 7.169.831 8 1.857 8h4.286A1.857 1.857 0 0 0 8 6.143V1.857A1.857 1.857 0 0 0 6.143 0Zm10 0h-4.286A1.857 1.857 0 0 0 10 1.857v4.286C10 7.169 10.831 8 11.857 8h4.286A1.857 1.857 0 0 0 18 6.143V1.857A1.857 1.857 0 0 0 16.143 0Zm-10 10H1.857A1.857 1.857 0 0 0 0 11.857v4.286C0 17.169.831 18 1.857 18h4.286A1.857 1.857 0 0 0 8 16.143v-4.286A1.857 1.857 0 0 0 6.143 10Zm10 0h-4.286A1.857 1.857 0 0 0 10 11.857v4.286c0 1.026.831 1.857 1.857 1.857h4.286A1.857 1.857 0 0 0 18 16.143v-4.286A1.857 1.857 0 0 0 16.143 10Z"/>
            </svg>
            <span class="ml-3">Mocks</span>
          </router-link>
        </li>
      </ul>
    </div>
  </aside>

</template>