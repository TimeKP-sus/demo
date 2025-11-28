<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">
  <ul class="sidebar-nav" id="sidebar-nav">
    <!-- Home -->
    <li class="nav-item">
      <a class="nav-link" href="${pageContext.request.contextPath}/admin">
        <i class="bi bi-grid"></i>
        <span>Trang chủ</span>
      </a>
    </li>

    <!-- Quan ly giang vien -->
    <li class="nav-item">
      <a
        class="nav-link collapsed"
        data-bs-target="#quanlygiangvien"
        data-bs-toggle="collapse"
        href="#"
      >
        <i class="bi bi-person-video3"></i>
        <span>Quản lý giảng viên</span>
        <i class="bi bi-chevron-down ms-auto"></i>
      </a>
      <ul
        id="quanlygiangvien"
        class="nav-content collapse"
        data-bs-parent="#sidebar-nav"
      >
        <li>
          <a
            href="${pageContext.request.contextPath}/admin/danhsachgiangvien/index"
          >
            <i class="bi bi-circle"></i>
            <span>Danh sách giảng viên</span>
          </a>
        </li>
      </ul>
    </li>

    <!-- Quan ly sinh vien -->
    <li class="nav-item">
      <a
        class="nav-link collapsed"
        data-bs-target="#quanlysinhvien"
        data-bs-toggle="collapse"
        href="#"
      >
        <i class="bi bi-people"></i>
        <span>Quản lý sinh viên</span>
        <i class="bi bi-chevron-down ms-auto"></i>
      </a>
      <ul
        id="quanlysinhvien"
        class="nav-content collapse"
        data-bs-parent="#sidebar-nav"
      >
        <li>
          <a
            href="${pageContext.request.contextPath}/admin/danhsachsinhvien/index"
          >
            <i class="bi bi-circle"></i>
            <span>Danh sách sinh viên</span>
          </a>
        </li>
      </ul>
    </li>

    <!-- Quan ly nganh -->
    <li class="nav-item">
      <a
        class="nav-link collapsed"
        data-bs-target="#quanlynganh"
        data-bs-toggle="collapse"
        href="#"
      >
        <i class="bi bi-diagram-3"></i>
        <span>Quản lý ngành</span>
        <i class="bi bi-chevron-down ms-auto"></i>
      </a>
      <ul
        id="quanlynganh"
        class="nav-content collapse"
        data-bs-parent="#sidebar-nav"
      >
        <li>
          <a
            href="${pageContext.request.contextPath}/admin/danhsachnganh/index"
          >
            <i class="bi bi-circle"></i>
            <span>Danh sách ngành</span>
          </a>
        </li>
      </ul>
    </li>

    <!-- Quan ly vien -->
    <li class="nav-item">
      <a
        class="nav-link collapsed"
        data-bs-target="#quanlyvien"
        data-bs-toggle="collapse"
        href="#"
      >
        <i class="bi bi-building"></i>
        <span>Quản lý viện</span>
        <i class="bi bi-chevron-down ms-auto"></i>
      </a>
      <ul
        id="quanlyvien"
        class="nav-content collapse"
        data-bs-parent="#sidebar-nav"
      >
        <li>
          <a href="${pageContext.request.contextPath}/admin/danhsachvien/index">
            <i class="bi bi-circle"></i>
            <span>Danh sách viện</span>
          </a>
        </li>
      </ul>
    </li>
    <!-- Quan ly khoa -->
    <li class="nav-item">
      <a
        class="nav-link collapsed"
        data-bs-target="#quanlykhoa"
        data-bs-toggle="collapse"
        href="#"
      >
        <i class="bi bi-journal-text"></i>
        <span>Quản lý khoa</span>
        <i class="bi bi-chevron-down ms-auto"></i>
      </a>
      <ul
        id="quanlykhoa"
        class="nav-content collapse"
        data-bs-parent="#sidebar-nav"
      >
        <li>
          <a href="${pageContext.request.contextPath}/admin/danhsachkhoa/index">
            <i class="bi bi-circle"></i>
            <span>Danh sách Khoa</span>
          </a>
        </li>
      </ul>
    </li>
    <!-- Quan ly lop -->
    <li class="nav-item">
      <a
        class="nav-link collapsed"
        data-bs-target="#quanlylop"
        data-bs-toggle="collapse"
        href="#"
      >
        <i class="bi bi-journal-text"></i>
        <span>Quản lý lớp</span>
        <i class="bi bi-chevron-down ms-auto"></i>
      </a>
      <ul
        id="quanlylop"
        class="nav-content collapse"
        data-bs-parent="#sidebar-nav"
      >
        <li>
          <a href="${pageContext.request.contextPath}/admin/danhsachlop/index">
            <i class="bi bi-circle"></i>
            <span>Danh sách lớp</span>
          </a>
        </li>
      </ul>
    </li>

    <!-- Quan ly lop hoc phan -->
    <li class="nav-item">
      <a
        class="nav-link collapsed"
        data-bs-target="#quanlylophocphan"
        data-bs-toggle="collapse"
        href="#"
      >
        <i class="bi bi-journal-text"></i>
        <span>Quản lý lớp học phần</span>
        <i class="bi bi-chevron-down ms-auto"></i>
      </a>
      <ul
        id="quanlylophocphan"
        class="nav-content collapse"
        data-bs-parent="#sidebar-nav"
      >
        <li>
          <a
            href="${pageContext.request.contextPath}/admin/danhsachlophocphan/index"
          >
            <i class="bi bi-circle"></i>
            <span>Danh sách lớp học phần</span>
          </a>
        </li>
      </ul>
    </li>
    <!-- het  -->
  </ul>
</aside>
<!-- End Sidebar-->
